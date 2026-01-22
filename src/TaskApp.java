import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TaskApp {

    private TaskManager manager = new TaskManager();
    private Scanner scanner = new Scanner(System.in);

    //アプリ実行
    public void run() {
        while (true) {
            showMenu();
            String input = scanner.nextLine();

            // メニュー選択
            switch (input) {
                case "1":
                    addTask();
                    break;
                case "2":
                    manager.listTasks();
                    break;
                case "3":
                    deleteTask();
                    break;
                case "4":
                    completeTask();
                    break;
                case "0":
                    System.out.println("プログラムを終了します。登録件数：" + manager.getTaskCount());
                    return;
                default:
                    System.out.println("入力が正しくありません");
            }
        }
    }

    // メニュー表示
    private void showMenu() {
        System.out.println("\n==== タスク管理アプリ ====");
        System.out.println("1：タスクを追加");
        System.out.println("2：タスク一覧を表示");
        System.out.println("3：タスクを削除");
        System.out.println("4：タスクを完了にする");
        System.out.println("0：終了");
        System.out.println("選択してください: ");
    }

    //タスクの追加
    private void addTask() {
        while (true) {
            try {
                System.out.print("タスク名を入力してください：");
                String title = scanner.nextLine();

                System.out.print("締切日を入力してください（例：2026-01-01）：");
                LocalDate deadline = LocalDate.parse(scanner.nextLine());

                manager.addTask(new Task(title, deadline));
                System.out.println("タスクを追加しました");
                break;

            //例外処理（日付形式が不正）
            } catch (DateTimeParseException e) {
                System.out.println("日付の形式が正しくありません");
            //例外処理（その他）
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
        

    // タスクの削除
    private void deleteTask() {

    // タスクが存在しない場合の処理
    if (!manager.hasTasks()) {
        System.out.println("タスクは登録されていません");
        return;
    }

    // タスク削除のループ
    while (true) {
        System.out.println("現在のタスク一覧");
        manager.listTasks();
        System.out.println("削除したいタスクのタイトルを入力してください: ");
        String title = scanner.nextLine();

        try {
            manager.deleteTask(title);
            System.out.println("タスクを削除しました。");
            break; 

        //例外処理
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            break;
        }
    }
}


    // タスクの完了
    private void completeTask() {

        // タスクが存在しない場合の処理
        if (!manager.hasTasks()) {
            System.out.println("タスクは登録されていません");
            return;
        }

        // タスク完了のループ
        while (true) {
            try {
                System.out.println("現在のタスク一覧");
                manager.listTasks();
                System.out.println("完了にするタスク名を入力してください：");
                String title = scanner.nextLine();

                manager.completeTask(title);
                System.out.println("タスクを完了にしました");
                break;

            //例外処理
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
