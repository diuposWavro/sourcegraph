package com.sourcegraph.config;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.actionSystem.impl.ActionButton;
import com.intellij.openapi.options.ShowSettingsUtil;
import com.intellij.openapi.project.DumbAwareAction;
import com.intellij.openapi.project.Project;
import com.intellij.util.IconUtil;
import com.intellij.util.ui.JBDimension;
import com.intellij.util.ui.JBUI;
import com.sourcegraph.Icons;
import javax.swing.*;
import org.jetbrains.annotations.NotNull;

public class GoToPluginSettingsButtonFactory {

  @NotNull
  public static ActionButton createGoToPluginSettingsButton(@NotNull Project project) {
    JBDimension actionButtonSize = JBUI.size(22, 22);

    AnAction action =
        new DumbAwareAction() {
          @Override
          public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
            ShowSettingsUtil.getInstance().showSettingsDialog(project, SettingsConfigurable.class);
          }
        };
    Presentation presentation = new Presentation("Open Plugin Settings");

    ActionButton button =
        new ActionButton(
            action, presentation, "Find with Sourcegraph popup header", actionButtonSize);

    Icon scaledIcon = IconUtil.scale(Icons.GearPlain, button, 13f / 12f);
    presentation.setIcon(scaledIcon);

    return button;
  }
}
