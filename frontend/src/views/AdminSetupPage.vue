<template>
  <div align="center">
    <h2>회원가입</h2>
    <admin-setup-form @submit="onSubmit"/>
  </div>
</template>

<script>
import axios from 'axios'
import AdminSetupForm from '@/components/AdminSetupForm.vue'
export default {
  name: 'AdminSetupPage',
  components: {
    AdminSetupForm
  },
  methods: {
    onSubmit (payload) {
      console.log('payload: ' + payload.userId +
                  ', ' + payload.userName +
                  ', ' + payload.userBorn +
                  ', ' + payload.userEmail +
                  ', ' + payload.userPhone)
      const { userId, userName, userPw, userBorn, userEmail, userPhone } = payload
      axios.post('http://localhost:7777/users/setup',
        { userId, userName, userPw, userBorn, userEmail, userPhone })
        .then(res => {
          alert('Register Success')
          this.$router.push({
            name: 'Home'
          })
        })
        .catch(err => {
          alert(err.response.data)
        })
    }
  }
}
</script>
