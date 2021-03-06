package com.maddyhome.idea.vim.ex.handler;

/*
 * IdeaVim - A Vim emulator plugin for IntelliJ Idea
 * Copyright (C) 2003-2005 Rick Maddy
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Editor;
import com.maddyhome.idea.vim.ex.*;
import com.maddyhome.idea.vim.group.CommandGroups;
import org.jetbrains.annotations.NotNull;

/**
 *
 */
public class SubstituteHandler extends CommandHandler {
  public SubstituteHandler() {
    super(new CommandName[]{
      new CommandName("s", "ubstitute"),
      new CommandName("&", ""),
      new CommandName("~", "")
    }, RANGE_OPTIONAL | ARGUMENT_OPTIONAL | WRITABLE);
  }

  public boolean execute(@NotNull Editor editor, DataContext context, @NotNull ExCommand cmd) throws ExException {
    LineRange range = cmd.getLineRange(editor, context, false);
    return CommandGroups.getInstance().getSearch().searchAndReplace(editor, context, range, cmd.getCommand(),
                                                                    cmd.getArgument());
  }
}
