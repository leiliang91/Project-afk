package csgo.dll;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.BaseTSD.ULONG_PTR;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinDef.SHORT;
import com.sun.jna.platform.win32.WinDef.BYTE;
import com.sun.jna.win32.StdCallLibrary;

public interface User32 extends StdCallLibrary {
    User32 INSTANCE = Native.loadLibrary("user32", User32.class);
    void mouse_event(DWORD dwFlags, DWORD dx, DWORD dy, DWORD dwData, ULONG_PTR dwExtraInfo);
    SHORT GetKeyState(int nVirtKey);
    void keybd_event(BYTE bVk, BYTE bScan, DWORD dwFlags, ULONG_PTR dwExtraInfo);
}
