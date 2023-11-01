public class Copy {
    private int copyId;
    private String status;

    public Copy(int copyId, String status) {
        this.copyId = copyId;
        this.status = status;
    }

    public int getCopyId(int copyId) {
        return copyId;
    }

    public void setCopyId(int copyId) {
        this.copyId = copyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}