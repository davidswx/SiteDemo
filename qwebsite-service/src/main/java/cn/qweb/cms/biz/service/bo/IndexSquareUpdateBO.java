package cn.qweb.cms.biz.service.bo;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

/*
 *  Created by xuebj - 2017/04/05.
 */

/**
 * @author xuebj email:xuebj@hundsun.com
 * @version 1.0
 * @since 1.0
 */

public class IndexSquareUpdateBO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *@Fields id:
     */
    @NotNull(message = "唯一键不能为空")
    private Long id;
    /**
     *@Fields site_name:名称
     */
    private String siteName;
    /**
     *@Fields site_link:地址
     */
    private String siteLink;
    /**
     *@Fields logo:图标
     */
    private String logo;
    private String oldLogoUrl;
    /**
     *@Fields description:描述
     */
    private String description;
    /**
     *@Fields views:点击次数
     */
    private Integer views;
    /**
     *@Fields is_enabled:是否显示
     */
    private String isEnabled;
    /**
     *@Fields priority:排列顺序
     */
    private Integer priority;
    /**
     *@Fields gmt_create:
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;
    /**
     *@Fields gmt_modified:
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setSiteName(String siteName){
        this.siteName = siteName;
    }
    public String getSiteName(){
        return siteName;
    }
    public void setSiteLink(String siteLink){
        this.siteLink = siteLink;
    }
    public String getSiteLink(){
        return siteLink;
    }
    public void setLogo(String logo){
        this.logo = logo;
        this.oldLogoUrl = logo;
    }
    public String getLogo(){
        return logo;
    }

    public String getOldLogoUrl() {
        return oldLogoUrl;
    }

    public void setOldLogoUrl(String oldLogoUrl) {
        this.oldLogoUrl = oldLogoUrl;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    public void setViews(Integer views){
        this.views = views;
    }
    public Integer getViews(){
        return views;
    }
    public void setIsEnabled(String isEnabled){
        this.isEnabled = isEnabled;
    }
    public String getIsEnabled(){
        return isEnabled;
    }
    public void setPriority(Integer priority){
        this.priority = priority;
    }
    public Integer getPriority(){
        return priority;
    }
    public void setGmtCreate(Date gmtCreate){
        this.gmtCreate = gmtCreate;
    }
    public Date getGmtCreate(){
        return gmtCreate;
    }
    public void setGmtModified(Date gmtModified){
        this.gmtModified = gmtModified;
    }
    public Date getGmtModified(){
        return gmtModified;
    }
    @Override
    public String toString(){
        return "IndexSquare{" +
                    "id='" + id + "\'," +
                    "siteName='" + siteName + "\'," +
                    "siteLink='" + siteLink + "\'," +
                    "logo='" + logo + "\'," +
                    "description='" + description + "\'," +
                    "views='" + views + "\'," +
                    "isEnabled='" + isEnabled + "\'," +
                    "priority='" + priority + "\'," +
                    "gmtCreate='" + gmtCreate + "\'," +
                    "gmtModified='" + gmtModified + "\'" +
                "}";
    }
        }