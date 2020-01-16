package cn.yishijie.domain;

import cn.yishijie.common.NewsReqDto;

import java.sql.Timestamp;

/**
 * @author chenjianhui on 2020/01/16
 */
public class NewsEntity {

    private long newsPK;
    private String content;
    private String title;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public NewsEntity() {
        //do nothing
    }

    public NewsEntity(NewsReqDto newsReqDto,long newsPK) {
        this.newsPK = newsPK;
        this.content = newsReqDto.getContent();
        this.title = newsReqDto.getTitle();
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    public long getNewsPK() {
        return newsPK;
    }

    public void setNewsPK(long newsPK) {
        this.newsPK = newsPK;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
