# ============================================
# МОДУЛЬ gas_mask (базовий клас)
# ============================================

class GasMask:
    """
    Базовий клас: Протигаз
    """

    def __init__(self, model, size, filter_type, protection_level, weight_kg):
        self.model = model
        self.size = size
        self.filter_type = filter_type
        self.protection_level = protection_level
        self.weight_kg = weight_kg

        self.filter_installed = True
        self.worn = False
        self.used_hours = 0

    def put_on(self):
        """Одягнути протигаз"""
        if self.worn:
            print("Протигаз вже одягнений")
        else:
            self.worn = True
            print("Протигаз одягнено")

    def take_off(self):
        """Зняти протигаз"""
        if not self.worn:
            print("Протигаз не одягнений")
        else:
            self.worn = False
            print("Протигаз знято")

    def replace_filter(self):
        """Замінити фільтр"""
        self.filter_installed = True
        self.used_hours = 0
        print("Фільтр замінено")

    def use(self, hours):
        """Використання протигаза"""
        self.used_hours += hours

    def protection_time(self):
        """Оцінка залишкового часу захисту"""
        base_time = self.protection_level * 2
        remaining = base_time - self.used_hours

        if not self.filter_installed:
            return 0

        return max(0, remaining)

    def __str__(self):
        return (
            f"Протигаз: модель={self.model}, "
            f"розмір={self.size}, рівень захисту={self.protection_level}, "
            f"вага={self.weight_kg} кг"
        )


# ============================================
# МОДУЛЬ commander_gas_mask (похідний клас)
# ============================================

class CommanderGasMask(GasMask):
    """
    Похідний клас: Протигаз командира
    """

    def __init__(
        self,
        model,
        size,
        filter_type,
        protection_level,
        weight_kg,
        has_radio=True,
        spare_filters=1
    ):
        super().__init__(model, size, filter_type, protection_level, weight_kg)
        self.has_radio = has_radio
        self.spare_filters = spare_filters

    def replace_filter(self):
        """Перевизначений метод заміни фільтра"""
        if self.spare_filters > 0:
            self.spare_filters -= 1
            super().replace_filter()
            print("Використано запасний фільтр командира")
        else:
            print("Запасних фільтрів немає!")

    def protection_time(self):
        """Командир має невеликий бонус"""
        return int(super().protection_time() * 1.1)

    def __str__(self):
        return (
            f"Протигаз командира: модель={self.model}, "
            f"радіозв’язок={'є' if self.has_radio else 'немає'}, "
            f"запасні фільтри={self.spare_filters}"
        )


# ============================================
# МОДУЛЬ main (точка входу)
# ============================================

def main():
    print("=== БАЗОВИЙ ПРОТИГАЗ ===")
    gas_mask = GasMask("PMK", "M", "A2", 6, 1.2)
    print(gas_mask)

    gas_mask.put_on()
    gas_mask.use(3)
    print("Залишок захисту:", gas_mask.protection_time(), "год")
    gas_mask.take_off()

    print("\n=== ПРОТИГАЗ КОМАНДИРА ===")
    commander_mask = CommanderGasMask("PMK-C", "L", "A2", 7, 1.3, True, 2)
    print(commander_mask)

    commander_mask.put_on()
    commander_mask.use(4)
    print("Залишок захисту:", commander_mask.protection_time(), "год")

    commander_mask.replace_filter()
    print("Залишок захисту після заміни:", commander_mask.protection_time(), "год")


# ============================================
# Запуск програми
# ============================================

if __name__ == "__main__":
    main()
