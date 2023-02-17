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
            human2.getCommunications().put(human1, RelationType.Brother);
        } else if (human1 instanceof Woman){
            human2.getCommunications().put(human1, RelationType.Sister);
        }
        if (human2 instanceof Man) {
            human1.getCommunications().put(human2, RelationType.Brother);
        }
        else if (human2 instanceof Woman) {
            human1.getCommunications().put(human2, RelationType.Sister);
        }
    }

    private void setSpouse() {
        if ((human1 instanceof Man && human2 instanceof Woman) ||
                (human1 instanceof Woman && human2 instanceof Man)){
            human1.getCommunications().put(human2, RelationType.Spouse);
            human2.getCommunications().put(human1, RelationType.Spouse);
        }
        else System.out.println(human1 + "и " + human2 + "не могут быть супругами");
    }

    private void setGrandparent() {
        if (human1 instanceof Man){
            human2.getCommunications().put(human1, RelationType.GrandFather);
        } else if (human1 instanceof Woman){
            human2.getCommunications().put(human1, RelationType.GrandMother);
        }
        if (human2 instanceof Man) {
            human1.getCommunications().put(human2, RelationType.Grandson);
        }
        else if (human2 instanceof Woman) {
            human1.getCommunications().put(human2, RelationType.Granddaughter);
        }
    }

    private void setChild() {
        if (human1 instanceof Man){
            human2.getCommunications().put(human1, RelationType.Son);
        } else if (human1 instanceof Woman){
            human2.getCommunications().put(human1, RelationType.Daughter);
        }
        if (human2 instanceof Man) {
            human1.getCommunications().put(human2, RelationType.Father);
        }
        else if (human2 instanceof Woman) {
            human1.getCommunications().put(human2, RelationType.Mother);
        }
    }

    private void setParent(){
        if (human1 instanceof Man){
            human2.getCommunications().put(human1, RelationType.Father);
        } else if (human1 instanceof Woman){
            human2.getCommunications().put(human1, RelationType.Mother);
        }
        if (human2 instanceof Man) {
            human1.getCommunications().put(human2, RelationType.Son);
        }
        else if (human2 instanceof Woman) {
            human1.getCommunications().put(human2, RelationType.Daughter);
        }
    }
    private void setGrandChild() {
        if (human1 instanceof Man){
            human2.getCommunications().put(human1, RelationType.Grandson);
        } else if (human1 instanceof Woman){
            human2.getCommunications().put(human1, RelationType.Granddaughter);
        }
        if (human2 instanceof Man) {
            human1.getCommunications().put(human2, RelationType.GrandFather);
        }
        else if (human2 instanceof Woman) {
            human1.getCommunications().put(human2, RelationType.GrandMother);
        }

    }
    private void setBrotherParent() {
        if (human1 instanceof Man){
            human2.getCommunications().put(human1, RelationType.Uncle);
        } else if (human1 instanceof Woman){
            human2.getCommunications().put(human1, RelationType.Aunt);
        }
        if (human2 instanceof Man) {
            human1.getCommunications().put(human2, RelationType.Nephew);
        }
        else if (human2 instanceof Woman) {
            human1.getCommunications().put(human2, RelationType.Niece);
        }
    }
    private void setChildBrother() {
        if (human1 instanceof Man){
            human2.getCommunications().put(human1, RelationType.Nephew);
        } else if (human1 instanceof Woman){
            human2.getCommunications().put(human1, RelationType.Niece);
        }
        if (human2 instanceof Man) {
            human1.getCommunications().put(human2, RelationType.Uncle);
        }
        else if (human2 instanceof Woman) {
            human1.getCommunications().put(human2, RelationType.Aunt);
        }
    }

}
