#language: ru

@TEST

  Функция: Поиск инфо

    Сценарий: 01 Находим id Морти
      Когда Находим id персонажа

    Сценарий: 02 Находим урл с последним эпизодом, где появлялся Морти
      То Находим урл с последним эпизодом

    Сценарий: 03 Находим информацию по Морти - расу и локацию
      И Находим расу Морти
      И Находим локацию Морти

    Сценарий: 04 Находим урл с последним персонажем в последнем эпизоде
      Когда Находим урл с последним персонажем

    Сценарий: 05 Находим информацию по последнему персонажу - имя, локацию, расу
      То Находим имя последнего персонажа в последнем эпизоде
      И Находим расу последнего персонажа
      И Находим локацию последнего персонажа

    Сценарий: 06 Проверка совпадения расы последнего персонажа с расой Морти
      И Проверка совпадения расы

    Сценарий: 07 Проверка на совпадение локации последнего персонажа и Морти
      И Проверка совпадения локации



