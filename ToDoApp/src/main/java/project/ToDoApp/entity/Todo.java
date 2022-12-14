package project.ToDoApp.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    @Column(nullable = false)
    private String title; // 내용

    @Column(nullable = false)
    private int todoOrder; // 우선순위

    @Column(nullable = false)
    private Boolean completed; // 완료 여부

    // todo 상태 저장
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private TodoStatus todoStatus = TodoStatus.TODO_IS_UNCOMPLETED; // 할 일이 처음 등록될 때 디폴트 값

    // todo 상태
    public enum TodoStatus {
        TODO_IS_COMPLETED("완료"),
        TODO_IS_UNCOMPLETED("미완료");

        @Getter
        private String status;

        TodoStatus(String status) {
            this.status = status;
        }
    }

    public Todo(Long id, String title, int todoOrder, boolean completed) {
        this.id = id;
        this.title = title;
        this.todoOrder = todoOrder;
        this.completed = completed;
    }
}
