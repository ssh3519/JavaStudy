package com.ssh.copy;

/**
 * @author ssh
 * @description
 * clone 拷贝当前对象， 必须实现 Cloneable 接口。
 * 浅拷贝对基本类型进行值拷贝，对引用类型拷贝引用；
 * 深拷贝对基本类型进行值拷贝，对引用类型对象不但拷贝对象的引用还拷贝对象的相关属性和方法。两者不同在于深拷贝创建了一个新的对象。
 * @date 2021/9/18 14:41
 */
public class ObjectCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher = new Teacher();
        teacher.setName("riemann");
        teacher.setAge(28);

        Student student1 = new Student();
        student1.setName("edgar");
        student1.setAge(18);
        student1.setTeacher(teacher);

        Student student2 = (Student) student1.clone();
        System.out.println("-------------拷贝后-------------");
        System.out.println(student2.getName());
        System.out.println(student2.getAge());
        System.out.println(student2.getTeacher().getName());
        System.out.println(student2.getTeacher().getAge());

        System.out.println("-------------修改老师的信息后-------------");
        // 修改老师的信息
        teacher.setName("jack");
        System.out.println("student1的teacher为： " + student1.getTeacher().getName());
        System.out.println("student2的teacher为： " + student2.getTeacher().getName());
    }
}
class Teacher implements Cloneable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Student implements Cloneable {
    private String name;
    private int age;
    private Teacher teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    //浅拷贝
    //@Override
    //public Object clone() throws CloneNotSupportedException {
    //    Object object = super.clone();
    //    return object;
    //}

    //深拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student student = (Student)super.clone();
        student.setTeacher((Teacher) student.getTeacher().clone());
        return student;
    }
}
