class Main{
    // This is a type of creation design pattern 
    // Here we are gonna generate the admit card ,the college the fees based on the marks obtained by the student 
    // The abstract factory creater 
    public static abstract class CollegeFactory{
        private static int cutOff = 150;
        public static CollegeFactory getCollegeFactory(int score){
            if(score > 150)
            return new PrivateCollegeFactory();
            else
            return new GovernmentCollegeFactory();
        }

        public abstract AdmitCard registerAdmitCard(String course);
        public abstract int getFee(String course);
    }

    // The factory creator
    static class PrivateCollegeFactory extends CollegeFactory{
        @Override
        public AdmitCard registerAdmitCard(String course) {
            switch(course.toLowerCase()){
                case "btech": return new EngineeringAdmitCard();
                case "arts": return new ArtsAdmitCard();
                case "doctor": return new MedicalAdmitCard();
                default: return null;
            }
        }

        @Override
        public int getFee(String course){
            switch(course.toLowerCase()){
                case "btech": return 50000;
                case "arts": return 25000;
                case "doctor": return 100000;
                default: return 0;
            }
        }
    }

    // The factory creator
    static class GovernmentCollegeFactory extends CollegeFactory{
        @Override
        public AdmitCard registerAdmitCard(String course) {
            switch(course.toLowerCase()){
                case "btech": return new GovtEngineeringAdmitCard();
                case "arts": return new GovtArtsAdmitCard();
                case "doctor": return new GovtMedicalAdmitCard();
                default: return null;
            }
        }

        @Override
        public int getFee(String course){
            switch(course.toLowerCase()){
                case "btech": return 15000;
                case "arts": return 10000;
                case "doctor": return 300000;
                default: return 0;
            }
        }
    }

    interface AdmitCard{
        public abstract void getAdmitCard();
    }

    static class EngineeringAdmitCard implements AdmitCard{
        public void getAdmitCard(){
            System.out.println("Recieved the admit card of Engineering college");
        }
    }

    static class ArtsAdmitCard implements AdmitCard{
        public void getAdmitCard(){
            System.out.println("Recieved the admit card of Arts college");
        }
    }

    static class MedicalAdmitCard implements AdmitCard{
        public void getAdmitCard(){
            System.out.println("Recieved the admit card of Medical college");
        }
    }

    static class GovtEngineeringAdmitCard implements AdmitCard{
        public void getAdmitCard(){
            System.out.println("Recieved the admit card of Govermment Engineering college");
        }
    }

    static class GovtArtsAdmitCard implements AdmitCard{
        public void getAdmitCard(){
            System.out.println("Recieved the admit card of Govermment Arts college");
        }
    }

    static class GovtMedicalAdmitCard implements AdmitCard{
        public void getAdmitCard(){
            System.out.println("Recieved the admit card of Govermment Medical college");
        }
    }

    public static void main(String[] args){
        int studScore = 170;
        String course = "Btech";
        CollegeFactory studCollege = CollegeFactory.getCollegeFactory(studScore);
        AdmitCard studAdmitCard = studCollege.registerAdmitCard(course);
        studAdmitCard.getAdmitCard();
        System.out.println(studCollege.getFee(course));
    }
}