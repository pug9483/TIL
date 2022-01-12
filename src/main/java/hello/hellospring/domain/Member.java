package hello.hellospring.domain;

import javax.persistence.*;

// Entity : JPA가 관리하는 Entity가 된다.
@Entity
public class Member {

    // db가 아이디를 자동으로 생성해주는 것을 '아이덴티티 전략'이라 한다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 시스템이 저장하는 임의의 값

    // 어노테이션을 가지고 데이터베이스와 매핑한다.
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
