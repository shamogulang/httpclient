package cn.yishijie.apibean.v1;

import cn.yishijie.common.NewsRespDto;

/**
 * @author chenjianhui on 2020/01/16
 */
public class NewsResp {

    private long newsPK;
    private String content;
    private String title;
    private long createdAt;

    public NewsResp() {
        //do nothing
    }

    public NewsResp(NewsRespDto newsRespDto) {
        this.newsPK = newsRespDto.getNewsPK();
        this.content = newsRespDto.getContent();
        this.title = newsRespDto.getTitle();
        this.createdAt = newsRespDto.getCreatedAt();
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
