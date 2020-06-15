cmake_minimum_required(VERSION 3.4.1)



add_library(afmod
             SHARED
            src/main/cpp/afmod.cpp
        src/main/cpp/decoder.h
        src/main/cpp/decoder.cpp
        src/main/cpp/extstrfuns.h
        src/main/cpp/extstrfuns.cpp
        src/main/cpp/simpled.cpp
        src/main/cpp/simpled.h
        )
add_library(utils
            SHARED
            src/main/cpp/utils.cpp)

set_target_properties(afmod
                      PROPERTIES CMakeLists.txt
                      afmod/src/${ANDROID_ABI}/libafmod.so
                      )
set_target_properties(utils
                      PROPERTIES CMakeLists.txt
                      utils/src/${ANDROID_ABI}/libutils.so
                      )
find_library(log-lib
              log
              )
target_link_libraries(utils
                      afmod
                      ${log-lib}
                      )