import sys

# Основний блок програми
if __name__ == "__main__":
    try:
        # Введення розміру квадратної матриці
        rows_num = int(input("Введіть розмір квадратної матриці: "))
        
        # Введення символу-заповнювача
        filler = input("Введіть символ-заповнювач: ")
        
        # Перевірка коректності введення символу
        # Якщо введено більше одного символу або жодного - вихід з програми
        if len(filler) == 0:
            print("Не введено символ-заповнювач")
            sys.exit(1)
        elif len(filler) > 1:
            print("Забагато символів-заповнювачів")
            sys.exit(1)

        # Список для зберігання зубчастого масиву
        jagged_list = []

        # Формування зубчастого списку
        for i in range(rows_num):
            current_row = []
            current_row.append("X")
            for j in range(rows_num):
                if j < rows_num - i:
                    current_row.append(filler)
            # Додаємо сформований рядок у масив
            if len(current_row) > 0:
                jagged_list.append(current_row)

        # Виведення результату на екран
        print("\nСформований зубчастий масив:")
        
        for row in jagged_list:
            # Для верхнього лівого трикутника відступи зліва не потрібні
            for item in row:
                print(item, end=" ")
            
            # Перехід на новий рядок
            print()

    except ValueError:
        print("Помилка: Розмір матриці має бути цілим числом.")
        sys.exit(1)