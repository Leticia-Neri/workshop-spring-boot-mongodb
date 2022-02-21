package com.leticialima.workshopmongo.domain;

public enum Role {
    ADMIN(1,"ROLE_ADMIN"),
    USER(2, "ROLE_USER");

    private int code;
    private String role;

    Role(int code, String role) {
        this.code = code;
        this.role = role;
    }

    Role() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public static Role toEnum(Integer code){
        if (code==null){
            return null;
        }
        for (Role n: Role.values()){
            if (code.equals(n.getCode())){
                return n;
            }
        }
        throw new IllegalArgumentException("ID inválido: " + code);
    }
}
