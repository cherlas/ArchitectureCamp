import component.*;

public class DrawWindow {
    public static void main(String[] args) {
        Window window = new Window("WINDOW窗口");
        window.addView(new Picture("LOGO图片"));
        window.addView(new Button("登陆"));
        window.addView(new Button("注册"));

        Frame frame = new Frame("FRAME1");
        frame.addView(new Label("用户名"));
        frame.addView(new TextBox("文本框"));
        frame.addView(new Label("密码"));
        frame.addView(new PasswordBox("密码框"));
        frame.addView(new CheckBox("复选框"));
        frame.addView(new TextBox("记住用户名"));
        frame.addView(new LinkLabel("忘记密码"));
        window.addView(frame);
        window.draw();
    }
}
