//LocalDateのインポート
import java.time.LocalDate;

public class Task {

    //タスクのタイトル、期限、完了状態を保持するフィールド
    private String title;          
    private LocalDate deadline;    
    private boolean completed;     

    // コンストラクタ
    public Task(String title, LocalDate deadline) {
        this.title = title;
        this.deadline = deadline;
        this.completed = false; // 作成時は未完了
    }

    // タイトルを取得
    public String getTitle() {
        return title;
    }

    // 期限を取得
    public LocalDate getDeadline() {
        return deadline;
    }

    // 完了状態を取得
    public boolean isCompleted() {
        return completed;
    }

    // タスクを完了にする
    public void complete() {
        this.completed = true;
    }

    // 一覧表示用の文字列
    @Override
    public String toString() {
        String status;
        if(isCompleted() == true)
            status = "[✓ 完了]";
        else
            status = "[未完了]";
        return status + title + "（期限:" + deadline + "）";
    }
}
