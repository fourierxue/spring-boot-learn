package cn.xd.learn.configuration;

import cn.xd.learn.entity.Pet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ConfigurationProperties获取配置文件，也可以使用@Value
 * @Value("${}) 通常用于注入外部化properties
 * @Value("#{})用来使用SpEL表达式
 * 单个配置用@Value，整个配置类使用@ConfigurationProperties
 */
@ConfigurationProperties("my")
@Component
public class LearnProperties {

    private String uuid;
    private String lastName;
    private String firstName;
    private Date birthday;
    private List<String> books;
    private List<String> language;
    private Map<String, String> map;
    private Map<String, String> innerLineMap;
    private Pet pet;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Map<String, String> getInnerLineMap() {
        return innerLineMap;
    }

    public void setInnerLineMap(Map<String, String> innerLineMap) {
        this.innerLineMap = innerLineMap;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "LearnProperties{" +
                "uuid='" + uuid + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthday=" + birthday +
                ", books=" + books +
                ", language=" + language +
                ", map=" + map +
                ", innerLineMap=" + innerLineMap +
                ", pet=" + pet +
                '}';
    }
}
