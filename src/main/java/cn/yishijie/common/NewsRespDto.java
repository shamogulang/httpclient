package cn.yishijie.common;

import cn.yishijie.domain.NewsEntity;

/**
 * @author chenjianhui on 2020/01/16
 */
public class NewsRespDto {

    private long newsPK;
    private String content;
    private String title;
    private long createdAt;

    public NewsRespDto() {
        //do nothing
    }

    public NewsRespDto(NewsEntity newsEntity) {
        this.newsPK = newsEntity.getNewsPK();
        this.content = newsEntity.getContent();
        this.title = newsEntity.getTitle();
        this.createdAt = newsEntity.getCreatedAt().getTime();
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

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
