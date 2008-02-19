/*
 * LineFilterOutputStream.java
 *
 * Created on 24.10.2007, 15:31:49
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package builder.smartfrog.util;

import hudson.model.StreamBuildListener;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

/**
 *
 * @author dominik
 */
public abstract class LineFilterOutputStream extends FilterOutputStream {

   private boolean wasCR;
   private static final byte CR = 13;
   private static final byte LF = 10;
   
   private ByteArrayOutputStream bos = new ByteArrayOutputStream(256);

   public LineFilterOutputStream(OutputStream out) {
      super(out);
   }

   public void write(byte[] bytes) {
      for (byte b : bytes) byteAcquired(b);
   }

   public void write(byte[] bytes, int off, int len) {
      for (int i = off; i < (off + len); i++) byteAcquired(bytes[i]);
   }

   public void write(int b) {
      byteAcquired((byte) b);
   }
   
   private void byteAcquired(byte b) {
      if ((b == LF) && (wasCR)) {
         wasCR = false;
         return;
      }
      
      wasCR = (b == CR);

      if ((b == CR) || (b == LF)) {
         String line = bos.toString();
         writeLine(line);
         bos.reset();
      } else {
         bos.write(b);
      }
      
   }
   
   protected abstract void writeLine(String line);
}