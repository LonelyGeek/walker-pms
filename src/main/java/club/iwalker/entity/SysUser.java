package club.iwalker.entity;

import club.iwalker.entity.SysRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

/**
 * Created by wangchen on 2017/1/7.
 */
@Entity
@Table(name = "tb_sys_user")
public class SysUser implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "lgn_nm")
    private String username;
    @Column(name = "pswrd")
    private String password;
    @Column(name = "actl_nm")
    private String actualName;
    @Column(name = "gender")
    private int gender;
    @Column(name = "id_card")
    private String idCard;
    @Column(name = "crt_tm")
    private Date createTime;
    @Column(name = "updt_tm")
    private Date updateTime;

    //    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_sys_user_role", joinColumns = {
            @JoinColumn(name = "user_cd", referencedColumnName = "code")}, inverseJoinColumns = {
            @JoinColumn(name = "role_cd", referencedColumnName = "code")})
    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private Set<SysRole> roleSet = new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        Set<SysRole> roles = this.getRoleSet();
        roles.stream().forEach(o -> {
            authorityList.add(new SimpleGrantedAuthority(o.getName()));
        });
        return authorityList;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActualName() {
        return actualName;
    }

    public void setActualName(String actualName) {
        this.actualName = actualName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Set<SysRole> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<SysRole> roleSet) {
        this.roleSet = roleSet;
    }
}
