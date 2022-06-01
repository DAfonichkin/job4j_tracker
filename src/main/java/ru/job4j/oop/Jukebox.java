package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        switch (position) {
            case 1:
                System.out.println("Пусть бегут неуклюже");
                System.out.println("Пешеходы по лужам,");
                System.out.println("А вода по асфальту рекой.");
                System.out.println("И не ясно прохожим");
                System.out.println("В этот день непогожий");
                System.out.println("Почему я весёлый такой.");
                break;
            case 2:
                System.out.println("Спят усталые игрушки, книжки спят.");
                System.out.println("Одеяла и подушки ждут ребят.");
                System.out.println("Даже сказка спать ложится,");
                System.out.println("Чтобы ночью нам присниться.");
                System.out.println("Ты ей пожелай:");
                System.out.println("Баю-бай.");
                break;
            default:
                System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox musicBox = new Jukebox();
        musicBox.music(1);
        musicBox.music(2);
        musicBox.music(3);
    }
}
