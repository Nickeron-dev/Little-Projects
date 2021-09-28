#include <iostream>
#include <Windows.h>

using std::cout;
using std::endl;

int main() 
{
	while (true) {
		Sleep(50);
		if (GetAsyncKeyState(VK_NUMPAD2) {
			INPUT input = {0};
			input.type = INPUT_MOUSE;
			input.mi.dwFlags = MOUSEEVENTF_LEFTDOWN;
			SendInput(1, &input, sizeof(input));
			ZeroMemory(&input, sizeof(input));
			input.type = INPUT_MOUSE;
			input.mi.dwFlags = MOUSEEVENTF_LEFTUP;
			SendInput(1, &input, sizeof(input));
			
		}
	}
	return 0;
}

