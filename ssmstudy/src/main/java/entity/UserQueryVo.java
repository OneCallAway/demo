package entity;

public class UserQueryVo {
    /**
     * 包装类型
     * 包装查询所需要的条件
     */

    //用户查询条件
    private UserCustom userCustom;

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

}
