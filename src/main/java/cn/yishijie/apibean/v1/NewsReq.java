package cn.yishijie.apibean.v1;

/**
 * @author chenjianhui on 2020/01/16
 */
public class NewsReq {
    //新闻内容
    private String content;
    //新闻标题
    private String title;

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
}
