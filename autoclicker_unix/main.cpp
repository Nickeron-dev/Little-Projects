#include <SFML/Graphics.hpp>
#include <ApplicationServices/ApplicationServices.h>
#include <thread>

int main()
{

    bool state = false;
    while (true)
    {
        if (state) {
            CGPoint pt;
            pt.x = 300;
            pt.y = 300;

            CGPostMouseEvent( pt, 0, 1, 1 );
            //sleep(1);
            std::this_thread::sleep_for(std::chrono::milliseconds(10));
            CGPostMouseEvent( pt, 0, 1, 0 );
            std::this_thread::sleep_for(std::chrono::milliseconds(10));

            // Following variant is also possible but it enforces me to change the position of my mouse
//                CGEventRef click1_down = CGEventCreateMouseEvent(
//                        NULL, kCGEventLeftMouseDown,
//                        CGPointMake(x, y),
//                        kCGMouseButtonLeft
//                );
            // Left button up at 250x250
//                CGEventRef click1_up = CGEventCreateMouseEvent(
//                        NULL, kCGEventLeftMouseUp,
//                        CGPointMake(x, y),
//                        kCGMouseButtonLeft
//                );
            //CGEventPost(kCGHIDEventTap, click1_down);
            //CGEventPost(kCGHIDEventTap, click1_up);
            //sleep(1);
            // Release the events
            //CFRelease(click1_up);
            //CFRelease(click1_down);
        }
        if (sf::Keyboard::isKeyPressed(sf::Keyboard::K)) {
            state = true;
        } else if (sf::Keyboard::isKeyPressed(sf::Keyboard::O)) {
            state = false;
        }
    }
}
