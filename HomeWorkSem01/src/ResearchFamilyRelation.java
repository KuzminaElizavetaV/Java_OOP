public class ResearchFamilyRelation {

    public static void printChildren(Human human){
        human.getInfo();
        int count = 0;
        for (var item: human.getCommunications().entrySet()) {
            if (item.getValue().equals(RelationType.Son)||item.getValue().equals(RelationType.Daughter)){
                System.out.print(item.getValue().getTranslation() + " ");
                item.getKey().getInfoLine();
                //System.out.println(item.getKey());
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
