package com.barissemerci.snoozeloo

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.barissemerci.snoozeloo.alarm.alarm_detail.presentation.AlarmDetailScreenRoot
import com.barissemerci.snoozeloo.alarm.alarm_list.presentation.AlarmListScreenRoot
import com.barissemerci.snoozeloo.alarm.triggered_alarm.presentation.TriggeredAlarmScreenRoot

@Composable
fun NavigationRoot(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination =  "alarm"
    ) {
        alarmGraph(navController)
    }

}

private fun NavGraphBuilder.alarmGraph(navController: NavHostController) {
    navigation(
        route = "alarm",
        startDestination = "alarm_list"
    ) {
        composable(
            route = "alarm_list"
        ) {
            AlarmListScreenRoot(
                onAlarmClick = {id ->
                    navController.navigate("alarm_detail?id=$id")
                },
                onAddAlarmClick = {
                    navController.navigate("alarm_detail")
                }
            )
        }
        composable(
            route = "alarm_detail?id={id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType  // Long değeri string olarak taşıyoruz
                    nullable = true
                    defaultValue = null
                }
            )
        ) {
                backStackEntry ->
            val idString = backStackEntry.arguments?.getString("id")
            val id = idString?.toLongOrNull()
            AlarmDetailScreenRoot(
                id = id,
                onCancelClick = {
                    navController.popBackStack()
                },
                onNavigateUpAfterSaved = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = "triggered_alarm"
        ) {
            TriggeredAlarmScreenRoot(


            )
        }

    }
}
