package my.demo.entity;


import java.io.Serializable;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title CodeType
 * @date 2021/4/2 13:40
 */

public class CodeType implements Serializable {


//    private static final long serialVersionUID = -3706387420717871375L;



    private String codeType;

    private String code;

    private String name;

    public String getCodeType(){
        return codeType;
    }
    public String getCode(){
        return code;
    }
    public String getName(){
        return name;
    }

    public void setCodeType(String codeType){
        this.codeType = codeType;
    }

    public void setCode(String code){
        this.code = code;
    }

    public void setName(String name){
        this.name = name;
    }


    @Override
    public String toString() {
        return "CodeType{" +
                "codeType='" + codeType + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
