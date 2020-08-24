import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Test from '../views/Test.vue'
import Test2 from '../views/Test2.vue'

// For Login System
import LoginPage from '../views/LoginPage.vue'
import AdminSetupPage from '../views/AdminSetupPage.vue'

// For Menu
import Memo from '../views/Memo.vue'
import Weather from '../views/Weather.vue'
import MyVlog from '../views/MyVlog.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/LoginPage',
    name: 'LoginPage',
    components: {
      default: LoginPage
    }
  },
  {
    path: '/AdminSetupPage',
    name: 'AdminSetupPage',
    components: {
      default: AdminSetupPage
    }
  },
  {
    path: '/Memo',
    name: 'Memo',
    components: {
      default: Memo
    }
  },
  {
    path: '/Weather',
    name: 'Weather',
    components: {
      default: Weather
    }
  },
  {
    path: '/MyVlog',
    name: 'MyVlog',
    components: {
      default: MyVlog
    }
  },
  {
    path: '/Test',
    name: 'Test',
    components: {
      default: Test
    }
  },
  {
    path: '/Test2',
    name: 'Test2',
    components: {
      default: Test2
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
