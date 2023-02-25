import FamilyTree.FamilyRelation;
import FamilyTree.ResearchFamilyRelation;
import ObjectWriteRead.FileHandler;
import Furniture.Wardrobe;
import People.Human;
import People.Man;
import People.Woman;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Woman("Елизавета", "К.", LocalDate.of(1981, 4, 18));
        Human human2 = new Woman("София", "К.", LocalDate.of(2011, 4, 6));
        Human human3 = new Man("Вячеслав", "К.", LocalDate.of(2008, 6, 25));
        Human human4 = new Man("Владислав", "К.", LocalDate.of(2000, 1, 4));
        Human human5 = new Woman("Татьяна", "К.", LocalDate.of(1957, 5, 4));
        Human human6 = new Man("Валерий", "К.", LocalDate.of(1957, 10, 17));
        Human human7 = new Man("Алексей", "К.", LocalDate.of(1985, 6, 26));
        Human human8 = new Woman("Наталия", "К.", LocalDate.of(1986, 1, 26));
        Human human9 = new Woman("Одиссея", "К.", LocalDate.of(2016, 1, 4));
        Human human10 = new Man("Дорофей", "К.", LocalDate.of(2019, 4, 8));
        Human human11 = new Woman("Надежда", "К.", LocalDate.of(2007, 3, 12));

        //FamilyRelation relation1 = new FamilyRelation(human1, human2, "parent");
        human2.addParent(human1);
        FamilyRelation relation2 = new FamilyRelation(human3, human1, "child");
        FamilyRelation relation3 = new FamilyRelation(human4, human1, "child");
        //FamilyRelation relation4 = new FamilyRelation(human5, human1, "parent");
        human1.addParent(human5);
        //FamilyRelation relation5 = new FamilyRelation(human6, human1, "parent");
        human1.addParent(human6);
        FamilyRelation relation6 = new FamilyRelation(human5, human6, "spouse");
        FamilyRelation relation7 = new FamilyRelation(human7, human1, "brother");
        FamilyRelation relation8 = new FamilyRelation(human8, human7, "spouse");
        //FamilyRelation relation9 = new FamilyRelation(human7, human9, "parent");
        human9.addParent(human7);
        FamilyRelation relation10 = new FamilyRelation(human9, human8, "child");
        //FamilyRelation relation11 = new FamilyRelation(human7, human10, "parent");
        human10.addParent(human7);
        FamilyRelation relation12 = new FamilyRelation(human10, human8, "child");
        FamilyRelation relation13 = new FamilyRelation(human7, human11, "parent");
        //FamilyRelation relation14 = new FamilyRelation(human5, human1, "parent");
        human1.addParent(human5);
        FamilyRelation relation15 = new FamilyRelation(human1, human6, "child");
        //FamilyRelation relation16 = new FamilyRelation(human5, human7, "parent");
        human7.addParent(human5);
        FamilyRelation relation18 = new FamilyRelation(human7, human6, "child");
        FamilyRelation relation19 = new FamilyRelation(human5, human2, "grandparent");
        FamilyRelation relation20 = new FamilyRelation(human5, human3, "grandparent");
        FamilyRelation relation21 = new FamilyRelation(human5, human4, "grandparent");
        FamilyRelation relation22 = new FamilyRelation(human5, human9, "grandparent");
        FamilyRelation relation23 = new FamilyRelation(human5, human10, "grandparent");
        FamilyRelation relation24 = new FamilyRelation(human5, human11, "grandparent");
        FamilyRelation relation25 = new FamilyRelation(human2, human6, "grandchild");
        FamilyRelation relation26 = new FamilyRelation(human3, human6, "grandchild");
        FamilyRelation relation27 = new FamilyRelation(human4, human6, "grandchild");
        FamilyRelation relation28 = new FamilyRelation(human9, human6, "grandchild");
        FamilyRelation relation29 = new FamilyRelation(human10, human6, "grandchild");
        FamilyRelation relation30 = new FamilyRelation(human11, human6, "grandchild");
        FamilyRelation relation31 = new FamilyRelation(human7, human2, "brother_parent");
        FamilyRelation relation32 = new FamilyRelation(human7, human3, "brother_parent");
        FamilyRelation relation33 = new FamilyRelation(human7, human4, "brother_parent");
        FamilyRelation relation34 = new FamilyRelation(human9, human1, "child_brother");
        FamilyRelation relation35 = new FamilyRelation(human10, human1, "child_brother");
        FamilyRelation relation36 = new FamilyRelation(human11, human1, "child_brother");

        System.out.println("-----------ВЫВОД НА ПЕЧАТЬ ДЕТЕЙ------------------");
        System.out.println();
        for (Human human: Human.getHumanList()) {
            ResearchFamilyRelation.printChildren(human);
            System.out.println();
        }
        System.out.println("-------ВЫВОД НА ПЕЧАТЬ ВСЕХ ТЕКУЩИХ СВЯЗЕЙ-------");
        System.out.println();
        for (Human human: Human.getHumanList()) {
            ResearchFamilyRelation.printAllFamilyRelation(human);
            System.out.println("------------------------------------------------");
            System.out.println();
        }
        System.out.println("-------ВЗАИМОДЕЙСТВИЕ ЧЕЛОВЕКА С ОБЪЕКТОМ РЕАЛЬНОГО МИРА-------");
        System.out.println(human1);
        System.out.println(human4);
        System.out.println("********************************");
        Wardrobe wardrobe1 = new Wardrobe(90, 210, 60, "белый", "спальня");
        Wardrobe wardrobe2 = new Wardrobe(120, 210, 60, "бежевый", "детская");
        System.out.println(wardrobe1);
        System.out.println(wardrobe2);
        System.out.println("********************************");
        human1.sayHumanPutThingWardrobe(human4, 2, wardrobe1);
        System.out.println(wardrobe1);
        System.out.println("********************************");
        human1.putThing(3, wardrobe2);
        System.out.println(wardrobe2);
        System.out.println("********************************");
        human1.sayHumanChangeLocationWardrobe(human4, wardrobe1, "гостевая");
        System.out.println(wardrobe1);
        System.out.println("********************************");
        human6.changeLocation(wardrobe2, "спальня родителей");
        System.out.println(wardrobe2);
        System.out.println("********************************");
        human8.sayHumanOpenWardrobe(human7, wardrobe2);
        human8.sayHumanCloseWardrobe(human7, wardrobe2);
        System.out.println("********************************");
        System.out.println(human2);
        human2.clearWardrobe(wardrobe1);
        System.out.println(human2);
        System.out.println("********************************");
        System.out.println(human11);
        human5.sayHumanClearWardrobe(human11, wardrobe2);
        System.out.println(human11);
        System.out.println("********************************");
        human2.putThing(10, wardrobe1);
        System.out.println(wardrobe1);
        human11.putThing(9, wardrobe2);
        System.out.println(wardrobe2);
        System.out.println("********************************");
        System.out.println(human1);
        human1.takeThing(2, wardrobe1);
        System.out.println("********************************");
        System.out.println(human8);
        human7.sayHumanTakeThing(human8, 3, wardrobe2);
        System.out.println("********************************");
        System.out.println("-------ЗАПИСЬ ОБЪЕКТОВ В ФАЙЛ-------");
        human1.setWritable(new FileHandler());
        human1.save();
        wardrobe1.setWritable(new FileHandler());
        wardrobe1.save();
        System.out.println("********************************");
        System.out.println("-------ЧТЕНИЕ ОБЪЕКТОВ ИЗ ФАЙЛА-------");
        human1.setReadable(new FileHandler());
        human1.read();
        wardrobe1.setReadable(new FileHandler());
        wardrobe1.read();
        System.out.println(human1.getCommunications());


    }
}