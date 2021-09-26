cmake_minimum_required(VERSION 3.14)
project(Autoclicker)
find_library(APP_SERVICES_LIBRARY ApplicationServices)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++17")

set(SOURCE_FILES main.cpp)
add_executable(Autoclicker ${SOURCE_FILES} ${APP_SERVICES_LIBRARY})
include_directories(/usr/local/include)
set(EXTRA_LIBS  ${APP_SERVICES_LIBRARY})
find_package(SFML 2.5 COMPONENTS system window graphics network audio REQUIRED)
include_directories(${SFML_INCLUDE_DIRS} ${APP_SERVICES_LIBRARY})
target_link_libraries(Autoclicker sfml-system sfml-window sfml-graphics sfml-audio sfml-network ${EXTRA_LIBS})

add_compile_options(-framework ApplicationServices)


