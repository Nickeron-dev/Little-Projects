cmake_minimum_required(VERSION 3.20)
project(QTClion)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_AUTOMOC ON)
set(CMAKE_AUTORCC ON)
set(CMAKE_AUTOUIC ON)


find_package(Qt5 COMPONENTS
        Core
        Gui
        Widgets
        REQUIRED)

add_executable(QTClion main.cpp)
target_link_libraries(QTClion
        Qt5::Core
        Qt5::Gui
        Qt5::Widgets
        )

