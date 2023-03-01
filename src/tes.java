public class tes {
    public static void main(String[] args) {
        String k = "Kishorekarthik P";
        for (int i = 0; i < k.length(); i++) {
            System.out.print(k.charAt(i));
            try {
                Thread.sleep(350);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println(Color.RESET+"Kishorekarthik P");
//        System.out.println(Color.BLUE_BACKGROUND+"Kishorekarthik P");
        System.out.println(Color.RESET+Color.BLUE_BOLD+"Kishorekarthik P");
        System.out.println(Color.RESET+Color.RED+"Kishorekarthik P");
        System.out.println(Color.RESET+Color.YELLOW+"Kishorekarthik P");
    }
}
