package com.equo.filesystem.provider.handlers;

import java.io.File;

import com.equo.filesystem.provider.responses.ContentResponse;
import com.equo.filesystem.provider.responses.ErrResponse;
import com.google.gson.JsonObject;

/**
 * Handler responsible for renaming actions.
 */
public class RenameFileHandler extends FileSystemHandler {
  @Override
  protected Object execute(JsonObject payload) {
    File actualFile = new File(getPathParam(payload));
    String newName = getContentParam(payload);
    String response = equoFileSystem.renameFile(actualFile, newName);
    if (response != null) {
      return new ContentResponse(response);
    }
    return new ErrResponse();
  }

  @Override
  protected String getCommandName() {
    return "_RenameFile";
  }
}
