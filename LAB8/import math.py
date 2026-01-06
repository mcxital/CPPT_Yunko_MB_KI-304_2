import math
import struct
import os
import sys

# Функція для запису результату у текстовий файл
def writeResTxt(fName, result):
    """
    Записує числове значення result у текстовий файл з ім'ям fName.
    """
    try:
        with open(fName, 'w', encoding='utf-8') as f:
            f.write(str(result))
        print(f"Результат успішно записано у текстовий файл: {fName}")
    except OSError as e:
        print(f"Помилка запису у файл {fName}: {e}")

# Функція для зчитування результату з текстового файлу
def readResTxt(fName):
    """
    Зчитує числове значення з текстового файлу fName.
    """
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'r', encoding='utf-8') as f:
                result = float(f.read())
        else:
            raise FileNotFoundError(f"Файл {fName} не знайдено.")
    except FileNotFoundError as e:
        print(e)
    except ValueError:
        print(f"Помилка: файл {fName} містить некоректні дані.")
    except Exception as e:
        print(f"Непередбачена помилка при читанні {fName}: {e}")
    
    return result

# Функція для запису результату у двійковий файл
def writeResBin(fName, result):
    """
    Записує числове значення result у двійковий файл з ім'ям fName
    використовуючи модуль struct.
    """
    try:
        with open(fName, 'wb') as f:
            # Використовуємо 'd' для double (8 байт), оскільки Python float має високу точність
            # У демо-прикладі використовувався 'f', але 'd' надійніше для математичних обчислень.
            f.write(struct.pack('d', result))
        print(f"Результат успішно записано у бінарний файл: {fName}")
    except OSError as e:
        print(f"Помилка запису у файл {fName}: {e}")

# Функція для зчитування результату з двійкового файлу
def readResBin(fName):
    """
    Зчитує числове значення з двійкового файлу fName.
    """
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'rb') as f:
                # Зчитуємо 8 байт (розмір double) і розпаковуємо
                packed_data = f.read(struct.calcsize('d'))
                if len(packed_data) == 8:
                    result = struct.unpack('d', packed_data)[0]
                else:
                    print(f"Помилка: файл {fName} має некоректний розмір.")
        else:
            raise FileNotFoundError(f"Файл {fName} не знайдено.")
    except FileNotFoundError as e:
        print(e)
    except Exception as e:
        print(f"Непередбачена помилка при читанні {fName}: {e}")
    
    return result

def calculate(x):
    """
    Обчислює вираз y = sin(x) / (x + tg(x))
    """
    try:
        # Обчислюємо тангенс
        tan_x = math.tan(x)
        
        # Обчислюємо знаменник
        denominator = x + tan_x
        
        # Перевірка на ділення на нуль
        if abs(denominator) < 1e-9:
            raise ValueError("Знаменник дорівнює нулю або дуже близький до нього.")
            
        y = math.sin(x) / denominator
        return y
    except ValueError as e:
        print(f"Математична помилка: {e}")
        return None
    except Exception as e:
        print(f"Помилка обчислення: {e}")
        return None

if __name__ == "__main__":
    try:
        # Введення даних користувачем
        data_str = input("Введіть значення x: ")
        x = float(data_str)
        
        # Виконання обчислень
        result = calculate(x)
        
        if result is not None:
            print(f"Обчислений результат y = {result}")
            
            # Запис у файли
            txt_file = "lab8_var29.txt"
            bin_file = "lab8_var29.bin"
            
            writeResTxt(txt_file, result)
            writeResBin(bin_file, result)
            
            # Перевірка (зчитування з файлів)
            print("-" * 30)
            print(f"Зчитано з txt файлу: {readResTxt(txt_file)}")
            print(f"Зчитано з bin файлу: {readResBin(bin_file)}")
            
    except ValueError:
        print("Помилка: введено некоректне число.")
    except Exception as e:
        print(f"Критична помилка: {e}")
        sys.exit(1)