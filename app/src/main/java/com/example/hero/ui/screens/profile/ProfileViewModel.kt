import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.hero.ui.data.local.database.AppDatabase
import com.example.hero.ui.data.local.model.LocalUser
import kotlinx.coroutines.launch

class  ProfileViewModel(application: Application) : AndroidViewModel(application) {

    private  val  db = AppDatabase.getDatabase(application)
    private  val dao = db.localUserDao()

    var profileState = mutableStateOf<LocalUser?>(null)
        private  set
    init {
        viewModelScope.launch {
            profileState.value = dao.getLocalUser()
        }
    }

    fun saveUser(localUser: LocalUser){
        viewModelScope.launch {
            dao.saveLocalUser(localUser)
            profileState.value = localUser
        }
    }
}