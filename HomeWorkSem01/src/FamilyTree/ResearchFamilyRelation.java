package FamilyTree;

import ObjectWriteRead.FileHandler;
import ObjectWriteRead.Readable;
import ObjectWriteRead.Writable;
import People.Human;

import java.io.File;
import java.io.Serializable;

/**
 * Класс "Исследование семейных отношений"
 */
public class ResearchFamilyRelation {

    public static void printChildren(Human human){
        human.getInfo();
        int count = 0;
        for (var item: human.getCommunications().entrySet()) {
            if (item.getValue().equals(RelationType.SON)||item.getValue().equals(RelationType.DAUGHTER)){
                System.out.print(item.getValue().getTranslation() + " ");
                item.getKey().getInfoLine();
                count++;
            }
        }
        if (count>0) System.out.println("--------------------------------------------------\nВСЕГО " + count + " ДЕТЕЙ");
        else System.out.println("Дети не найдены!");
    }

    public static void printAllFamilyRelation(Human human){
        human.getInfo();
        System.out.println("РОДСТВЕННЫЕ СВЯЗИ У ЭТОГО ОБЪЕКТА ТАКИЕ:");
        for (var item: human.getCommunications().entrySet()) {
            System.out.print(item.getValue().getTranslation() + " ");
            item.getKey().getInfoLine();
        }
    }
}
