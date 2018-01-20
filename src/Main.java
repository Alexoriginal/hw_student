import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static int studentAgeFrom7To12Count=0;
    private static int studentAgeMoreThen12Count=0;
    private static int studentCount=40;

    private static ClassRoom[]classRoomMass;

    public static void main(String[] args) {



        ClassRoom classA=creatNewClass("A",12);
        ClassRoom classB=creatNewClass("A",15);

        addStudentsToClasses(classA,classB);

        System.out.println("student count with age from 7 to 12 is"+studentAgeFrom7To12Count);
        System.out.println("student count with age from 12 is"+studentAgeMoreThen12Count);

        System.out.println("-------------------");
        System.out.println(classA.getStudCount()+" - student count in Class A");
        System.out.println(classB.getStudCount()+" - student count in Class B");


        System.out.println("----------------------");
        System.out.println("Class A");
        classA.printStidentNameInClass();
        System.out.println("Class B");
        classB.printStidentNameInClass();

        System.out.println("-----------------");
        getStudentByNameFromAnyClass("A11cov");

    }

    private static void showAllClasses() {
        for (ClassRoom roomMass : classRoomMass) {
            System.out.println(roomMass.getClassWord() + " word of class, " + roomMass.getStudCount() + " student in class");
        }
    }

    private static void getStudentByNameFromAnyClass(String name) {
        for (ClassRoom roomMass : classRoomMass) {
            for (Student s:roomMass.studMass)
                if (s.getName()!= null && s.getName().equals(name)) {
                    System.out.println(name + " study in class " + roomMass.getClassWord());
                }
        }
    }




    private static ClassRoom creatNewClass(String classWord, int classLimit) {

        ClassRoom newSchoolClass=new ClassRoom(classWord,classLimit);
        if(classRoomMass==null){
            classRoomMass=new ClassRoom[1];
            classRoomMass[0]=newSchoolClass;
        }else{
            ClassRoom[]updateClassRoomMass= Arrays.copyOf(classRoomMass,classRoomMass.length+1);
            for(int i=0;i<updateClassRoomMass.length;i++){
                if(updateClassRoomMass[i]==null){
                    updateClassRoomMass[i]=newSchoolClass;
                }
            }
            classRoomMass=updateClassRoomMass;
        }

        return newSchoolClass;
    }

    private static void addStudentsToClasses(ClassRoom classA,ClassRoom classB){
        for(Student student:initAllStudent()){
            if(student.getAge()>=7&&student.getAge()<12){
                classA.addStudentToClass(student);
            }else if(student.getAge()>=12){
                classB.addStudentToClass(student);
            }

        }
    }
    public static Student[] initAllStudent(){
        Student[] students=new Student[studentCount];
        int min=7;
        int max=12;
        int randomAge;
        Random random=new Random();
        for(int i=0;i<students.length;i++){
            randomAge= ThreadLocalRandom.current().nextInt(min, max + 1);
            String studName="A"+randomAge+"cov";
            Student stud=new Student(studName,randomAge);
            students[i]=stud;
            studentCountByAgeInfo(randomAge);

        }
        System.out.println(students.length+"all students in school");
        return students;
    }

    private static void studentCountByAgeInfo(int randomAge){
        if(randomAge>=7&&randomAge<12){
            studentAgeFrom7To12Count++;
        }else{
            studentAgeMoreThen12Count++;
        }
    }

}
