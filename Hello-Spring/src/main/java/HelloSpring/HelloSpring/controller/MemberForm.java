package HelloSpring.HelloSpring.controller;

public class MemberForm {

    //members/createMemberForm.html의 input name = name과 연결되는 변수
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
