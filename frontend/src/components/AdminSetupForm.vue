<template>
  <form @submit.prevent="submit">
    <table>
      <tr>
        <td>아이디</td>
        <td><input type="text" v-model="userId"></td>
      </tr>
      <tr>
        <td>비번</td>
        <td><input type="password" v-model="userPw"></td>
      </tr>
      <tr>
        <td>이름</td>
        <td><input type="text" v-model="userName"></td>
      </tr>
      <tr>
        <td>사는곳</td>
        <td><input type="text" v-model="userBorn"></td>
      </tr>
      <tr>
        <td>이메일</td>
        <td><input type="text" v-model="userEmail"></td>
      </tr>
      <tr>
        <td>전화번호</td>
        <td><input type="text" v-model="userPhone"></td>
      </tr>
    </table>

    <div>
      <button type="submit">회원가입</button>
    </div>
  </form>
</template>

<script>
export default {
  name: 'AdminSetupForm',
  data () {
    return {
      userId: '',
      userName: '',
      userPw: '',
      userBorn: '',
      userEmail: '',
      userPhone: ''
    }
  },
  methods: {
    submit () {
      console.log('this: ' + this.userId +
                  ', ' + this.userName +
                  ', ' + this.userPw +
                  ', ' + this.userBorn +
                  ', ' + this.userEmail +
                  ', ' + this.userPhone)
      const { userId, userName, userPw, userBorn, userEmail, userPhone } = this
      this.$emit('submit', { userId, userName, userPw, userBorn, userEmail, userPhone })
    }
  }
}
</script>
