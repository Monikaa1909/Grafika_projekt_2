package project_2_graphic;

public class Comment {
    private String commentContent;
    private int index;

    public Comment(String commentContent, int index) {
        this.commentContent = commentContent;
        this.index = index;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public int getIndex() {
        return index;
    }
}
