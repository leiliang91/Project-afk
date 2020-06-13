package csgo;

import com.sun.jna.platform.win32.BaseTSD.ULONG_PTR;
import com.sun.jna.platform.win32.WinDef.SHORT;
import com.sun.jna.platform.win32.WinDef.BYTE;
import com.sun.jna.platform.win32.WinDef.DWORD;
import csgo.dll.Kernel32;
import csgo.dll.User32;

import java.util.Random;

public class CSGOCore {
    private static final User32 user32 = User32.INSTANCE;
    private static final Kernel32 kernel32 = Kernel32.INSTANCE;


    private static final SHORT zeroSHORT = new SHORT();
    private static final BYTE zeroBYTE = new BYTE();
    private static final DWORD zeroDWORD = new DWORD();
    private static final ULONG_PTR zeroULONG_PTR = new ULONG_PTR();

    private static final BYTE spaceBYTE = new BYTE(32);
    private static final BYTE spaceScanBYTE = new BYTE(57);
    private static final BYTE wBYTE = new BYTE(87);
    private static final BYTE wScanBYTE = new BYTE(17);
    private static final BYTE aBYTE = new BYTE(65);
    private static final BYTE aScanBYTE = new BYTE(30);
    private static final BYTE sBYTE = new BYTE(83);
    private static final BYTE sScanBYTE = new BYTE(31);
    private static final BYTE dBYTE = new BYTE(68);
    private static final BYTE dScanBYTE = new BYTE(32);


    private static final Random random = new Random();

    private static final DWORD dwFlags_move = new DWORD(1);

    private static final DWORD dwFlags_Ldown = new DWORD(2);
    private static final DWORD dwFlags_Lup = new DWORD(4);

    private static final DWORD dwData = new DWORD();  //0
    private static final ULONG_PTR dwExtraInfo = new ULONG_PTR();
    public static void mouse_move(long x, long y) {
        user32.mouse_event(dwFlags_move, new DWORD(x), new DWORD(y), dwData, dwExtraInfo);
    }

    public static void beep(long freq, long dur) {
        kernel32.Beep(new DWORD(freq), new DWORD(dur));
    }

    public static boolean isSpaceDown() {
        return user32.GetKeyState(32).compareTo(zeroSHORT) < 0;
    }

    public static boolean isVDown() {
        return user32.GetKeyState(86).compareTo(zeroSHORT) < 0;
    }

    public static boolean isLButtonDown() {
        return user32.GetKeyState(1).compareTo(zeroSHORT) < 0;
    }

    public static boolean isRButtonDown() {
        return user32.GetKeyState(2).compareTo(zeroSHORT) < 0;
    }

    public static boolean isMButtonDown() {
        return user32.GetKeyState(4).compareTo(zeroSHORT) < 0;
    }

    public static boolean isAltDown() {
        return user32.GetKeyState(18).compareTo(zeroSHORT) < 0;
    }

    public static boolean is6Down() {return user32.GetKeyState(54).compareTo(zeroSHORT) < 0;}

    public static boolean isHomeDown() {
        return user32.GetKeyState(36).compareTo(zeroSHORT) < 0;
    }

    public static boolean isEndDown() {
        return user32.GetKeyState(35).compareTo(zeroSHORT) < 0;
    }

    public static boolean isTabDown() {
        return user32.GetKeyState(9).compareTo(zeroSHORT) < 0;
    }

    public static boolean isWDown() {
        return user32.GetKeyState(87).compareTo(zeroSHORT) < 0;
    }

    public static boolean isADown()  {
        return user32.GetKeyState(65).compareTo(zeroSHORT) < 0;
    }

    public static boolean isSDown()  {
        return user32.GetKeyState(83).compareTo(zeroSHORT) < 0;
    }

    public static boolean isDDown()  {
        return user32.GetKeyState(68).compareTo(zeroSHORT) < 0;
    }

    public static boolean isCDown()  {
        return user32.GetKeyState(67).compareTo(zeroSHORT) < 0;
    }


    private static void pressKey(BYTE bvk, BYTE bScan) {
        user32.keybd_event(bvk, bScan, zeroDWORD, zeroULONG_PTR);
        user32.keybd_event(bvk, bScan, new DWORD(2), zeroULONG_PTR);
    }

    private static void pressKey(BYTE bvk, BYTE bScan, long gap) throws InterruptedException {
        user32.keybd_event(bvk, bScan, zeroDWORD, zeroULONG_PTR);
        Thread.sleep(gap);
        user32.keybd_event(bvk, bScan, new DWORD(2), zeroULONG_PTR);
    }

    public static void pressSpace() {
        pressKey(spaceBYTE, spaceScanBYTE);
    }

    public static void pressW() {
        pressKey(wBYTE, wScanBYTE);
    }

    public static void pressA() {
        pressKey(aBYTE, aScanBYTE);
    }

    public static void pressS() {
        pressKey(sBYTE, sScanBYTE);
    }

    public static void pressD(long gap) throws InterruptedException {
        pressKey(dBYTE, dScanBYTE, gap);
    }

    public static void pressA(long gap) throws InterruptedException {
        pressKey(aBYTE, aScanBYTE, gap);
    }

    public static void pressW(long gap) throws InterruptedException {
        pressKey(wBYTE, wScanBYTE, gap);
    }

    public static void pressS(long gap) throws InterruptedException {
        pressKey(sBYTE, sScanBYTE, gap);
    }

    public static void pressLMouse() throws InterruptedException {
        user32.mouse_event(dwFlags_Ldown, dwData, dwData, dwData, dwExtraInfo);
        user32.mouse_event(dwFlags_Lup, dwData, dwData, dwData, dwExtraInfo);
    }
}
