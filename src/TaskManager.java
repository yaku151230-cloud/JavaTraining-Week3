import java.time.LocalDate;
import java.util.ArrayList;

public class TaskManager {

    private ArrayList<Task> tasks;

    // コンストラクタ
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // タスク追加
    public void addTask(Task task) {
        if (task.getTitle().isBlank()) {
            throw new IllegalArgumentException("タスク名が空欄です");
        }

        if (task.getDeadline().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("締切日は今日以降の日付を指定してください");
        }

        tasks.add(task);
    }

    // タスク一覧表示
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("タスクは登録されていません");
            return;
        }

        // タスク一覧表示(ラムダ式)
        tasks.forEach(task -> System.out.println(task));
    }

    // タスク削除
    public void deleteTask(String title) {

        // タスクが空欄の場合の処理
        if (title.isBlank()) {
            throw new IllegalArgumentException("タスク名が空欄です");
        }

        // タスクが存在しない場合の処理
        if (tasks.isEmpty()) {
            throw new IllegalArgumentException("タスクは登録されていません");
        }

        // タスク削除の処理
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                tasks.remove(task);
                return;
            }
        }

        // 該当タスクが見つからない場合の処理
        throw new IllegalArgumentException("該当するタスクが見つかりません");
    }

    // タスク完了
    public void completeTask(String title) {

    // タスクが空欄の場合の処理
    if (title.isBlank()) {
        throw new IllegalArgumentException("タイトルが入力されていません");
    }

    // タスクが存在しない場合の処理
    if (tasks.isEmpty()) {
        throw new IllegalArgumentException("タスクは登録されていません");
    }

    // タスク完了の処理
    for (Task task : tasks) {
        if (task.getTitle().equals(title)) {

            // 既に完了している場合の処理
            if(task.isCompleted() != true){
                task.complete();
                return;
            }else{
                throw new IllegalArgumentException("既に完了しているタスクです");
            }
        }
    }

    // 該当タスクが見つからない場合の処理
    throw new IllegalArgumentException("該当するタスクが見つかりません。");
    }

    // タスク総数
    public int getTaskCount() {
        return tasks.size();
    }

    // タスクが存在するかどうか
    public boolean hasTasks() {
    return !tasks.isEmpty();
    }
}



