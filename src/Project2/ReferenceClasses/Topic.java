package Project2.ReferenceClasses;
public class Topic {
    private String module;
    private String task;

    public Topic(String module, String task) {
        this.module = module;
        this.task = task;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return module;
    }
}

