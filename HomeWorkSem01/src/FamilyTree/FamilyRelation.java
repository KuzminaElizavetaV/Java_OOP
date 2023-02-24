package FamilyTree;

import People.Human;
import People.Man;
import People.Woman;

/**
 * Класс "Семейные отношения"
 */
public class FamilyRelation {
    private final Human human1;
    private final Human human2;
    /**
     * Конструктор класса "Семейные отношения"
     * @param human1 это человек, который является relationType (тип связи) по отношению к human2
     * @param human2 это человек, кому добавляется связь, указанная в relationType
     * @param relationType это тип родства - кем приходится human1 для human2
     */
    public FamilyRelation(Human human1, Human human2, String relationType) {
        this.human1 = human1;
        this.human2 = human2;
        switch (relationType) {
            case "parent" -> setParent();
            case "child" -> setChild();
            case "grandparent" -> setGrandparent();
            case "spouse" -> setSpouse();
            case "brother" -> setBrother();
            case "grandchild" -> setGrandChild();
            case "brother_parent" -> setBrotherParent();
            case "child_brother" -> setChildBrother();
            default -> System.out.println("Неизвестная степени родства");
        }
    }

    private void setBrother() {
        if (human1 instanceof Man){
            human2.getCommunications().put(human1, RelationType.BROTHER);
        } else if (human1 instanceof Woman){
            human2.getCommunications().put(human1, RelationType.SISTER);
        }
        if (human2 instanceof Man) {
            human1.getCommunications().put(human2, RelationType.BROTHER);
        }
        else if (human2 instanceof Woman) {
            human1.getCommunications().put(human2, RelationType.SISTER);
        }
    }

    private void setSpouse() {
        if ((human1 instanceof Man && human2 instanceof Woman) ||
                (human1 instanceof Woman && human2 instanceof Man)){
            human1.getCommunications().put(human2, RelationType.SPOUSE);
            human2.getCommunications().put(human1, RelationType.SPOUSE);
        }
        else System.out.println(human1 + "и " + human2 + "не могут быть супругами");
    }

    private void setGrandparent() {
        if (human1 instanceof Man){
            human2.getCommunications().put(human1, RelationType.GRANDFATHER);
        } else if (human1 instanceof Woman){
            human2.getCommunications().put(human1, RelationType.GRANDMOTHER);
        }
        if (human2 instanceof Man) {
            human1.getCommunications().put(human2, RelationType.GRANDSON);
        }
        else if (human2 instanceof Woman) {
            human1.getCommunications().put(human2, RelationType.GRANDDAUGHTER);
        }
    }

    private void setChild() {
        if (human1 instanceof Man){
            human2.getCommunications().put(human1, RelationType.SON);
        } else if (human1 instanceof Woman){
            human2.getCommunications().put(human1, RelationType.DAUGHTER);
        }
        if (human2 instanceof Man) {
            human1.getCommunications().put(human2, RelationType.FATHER);
        }
        else if (human2 instanceof Woman) {
            human1.getCommunications().put(human2, RelationType.MOTHER);
        }
    }

    private void setParent(){
        if (human1 instanceof Man){
            human2.getCommunications().put(human1, RelationType.FATHER);
        } else if (human1 instanceof Woman){
            human2.getCommunications().put(human1, RelationType.MOTHER);
        }
        if (human2 instanceof Man) {
            human1.getCommunications().put(human2, RelationType.SON);
        }
        else if (human2 instanceof Woman) {
            human1.getCommunications().put(human2, RelationType.DAUGHTER);
        }
    }
    private void setGrandChild() {
        if (human1 instanceof Man){
            human2.getCommunications().put(human1, RelationType.GRANDSON);
        } else if (human1 instanceof Woman){
            human2.getCommunications().put(human1, RelationType.GRANDDAUGHTER);
        }
        if (human2 instanceof Man) {
            human1.getCommunications().put(human2, RelationType.GRANDFATHER);
        }
        else if (human2 instanceof Woman) {
            human1.getCommunications().put(human2, RelationType.GRANDMOTHER);
        }

    }
    private void setBrotherParent() {
        if (human1 instanceof Man){
            human2.getCommunications().put(human1, RelationType.UNCLE);
        } else if (human1 instanceof Woman){
            human2.getCommunications().put(human1, RelationType.AUNT);
        }
        if (human2 instanceof Man) {
            human1.getCommunications().put(human2, RelationType.NEPHEW);
        }
        else if (human2 instanceof Woman) {
            human1.getCommunications().put(human2, RelationType.NIECE);
        }
    }
    private void setChildBrother() {
        if (human1 instanceof Man){
            human2.getCommunications().put(human1, RelationType.NEPHEW);
        } else if (human1 instanceof Woman){
            human2.getCommunications().put(human1, RelationType.NIECE);
        }
        if (human2 instanceof Man) {
            human1.getCommunications().put(human2, RelationType.UNCLE);
        }
        else if (human2 instanceof Woman) {
            human1.getCommunications().put(human2, RelationType.AUNT);
        }
    }
}
