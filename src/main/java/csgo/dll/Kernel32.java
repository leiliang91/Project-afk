package csgo.dll;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinDef.BOOL;
import com.sun.jna.win32.StdCallLibrary;

public interface Kernel32 extends StdCallLibrary {
    Kernel32 INSTANCE = Native.loadLibrary("Kernel32", Kernel32.class);
    BOOL Beep(DWORD dwFreq, DWORD dwDuration);
}
