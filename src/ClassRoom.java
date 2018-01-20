public class ClassRoom {
    private String classWord;
    private int classLimit;
    Student[] studMass;

    public ClassRoom(int classLimit) {
        studMass = new Student[classLimit];
    }

    public ClassRoom(String classWord, int classLimit) {
        this.classWord = classWord;
        this.classLimit = classLimit;
        studMass = new Student[classLimit];
    }

    public String getClassWord() {
        return classWord;
    }

    public void setClassWord(String classWord) {
        this.classWord = classWord;
    }

    public int getClassLimit() {
        return classLimit;
    }

    public void setClassLimit(int classLimit) {
        this.classLimit = classLimit;
    }

    public Student[] getStudMass() {
        return studMass;
    }

    public void setStudMass(Student[] studMass) {
        this.studMass = studMass;
    }

    private int studCount = 0;// переменная кол-ва студентов

    public int getStudCount() {
        return studCount;
    }

    public void setStudCount(int studCount) {
        this.studCount = studCount;
    }

    public void addStudentToClass(Student s) {
        if (studCount < studMass.length) {
            for (int i = 0; i < studMass.length; i++) {
                if (studMass[i] == null) {
                    studMass[i] = s;
                    studCount++;
                    break;
                }
            }
        } else {
            System.out.println("NET MEST");
        }
    }

    public void printStudentNameAndAgeInClass() {
        for (Student student : studMass) {
            if (student != null) {
                System.out.println(student.getName() + " , " + student.getAge());
            }
        }
    }

    public void printStidentNameInClass() {
        for (Student student : studMass) {
            if (student != null) {
                System.out.println(student.getName());
            }
        }
    }


    public Student getStudentByName(String name){
        for(Student stud:studMass){
            if(stud.getName().equals(name)){
                return stud;
            }
        }
        return null;
    }


}
