package main;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.ui.JBColor;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;

/**
 * @author:lezzy
 * @Date:2020/7/10 14:16
 */
public class EasyTranslateAction extends AnAction {


    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Editor data = e.getData(PlatformDataKeys.EDITOR);
        String src= null;
        try {
            src = data.getSelectionModel().getSelectedText().toLowerCase();
        } catch (Exception exception) {
            Messages.showErrorDialog("我佛慈悲，还请施主选择一下单词","ERROR");
            return;
        }
        if (StringUtils.isBlank(src)){
            Messages.showErrorDialog("施主，莫要调皮","ERROR");
            return;
        }
        doHandlerHttpGet(src,data);
    }

    private void doHandlerHttpGet(String src, Editor data) {
        String result = TranslateConfig.getTranslateResult(src, "auto", "zh");
        ApplicationManager.getApplication().invokeLater(new Runnable() {
            public void run() {
                JBPopupFactory factory = JBPopupFactory.getInstance();
                factory.createHtmlTextBalloonBuilder(result, null, new JBColor(new Color(186, 238, 186), new Color(73, 117, 73)), null)
                        .setFadeoutTime(5000)
                        .createBalloon()
                        .show(factory.guessBestPopupLocation(data), Balloon.Position.below);
            }
        });
    }
}
