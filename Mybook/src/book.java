public class book {
    //book_id 和 time_left 在数据库里面是 int ,但是这里给他弄了个Integer
    private Integer book_id;
    private Integer time_left;
    private String book_name;

    public book(Integer book_id,Integer time_left,String book_name){
        super();
        this.book_id=book_id;
        this.book_name=book_name;
        this.time_left=time_left;
    }

    public book(String book_name){
        super();
    }



    public Integer getBook_id() {
        return book_id;
    }

    public Integer getTime_left() {
        return time_left;

    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setTime_left(Integer time_left) {
        this.time_left = time_left;
    }

    @Override
    public String toString() {
        return "book{" +
                "book_id=" + book_id +
                ", time_left=" + time_left +
                ", book_name='" + book_name + '\'' +
                '}';
    }
}


